package com.bootcamp.desafiospring.melitools.service;

import com.bootcamp.desafiospring.melitools.dto.PostDTO;
import com.bootcamp.desafiospring.melitools.dto.UserDTO;
import com.bootcamp.desafiospring.melitools.dto.response.*;
import com.bootcamp.desafiospring.melitools.entity.UserListNode;
import com.bootcamp.desafiospring.melitools.exception.*;
import com.bootcamp.desafiospring.melitools.repository.MeliToolsRepository;
import com.bootcamp.desafiospring.melitools.utils.Constants;
import com.bootcamp.desafiospring.melitools.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class MeliToolsService implements MeliToolsServiceInterface{

    @Autowired
    private MeliToolsRepository mtRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(MeliToolsService.class);

    /**
     * Method to follow a user
     * @param userId         {int} id of the user who wants to follow other user.
     * @param userIdToFollow {int} id of the user who is going to be followed.
     * @return {ResponseSimple} response with HttpStatus and message.
     * @throws IOException           if the singleto doesn't find the users file.
     * @throws UserNotFoundException if the user with one of the received ids doesn't exists.
     * @author Daniel Alejandro López Hernández
     */
    public ResponseSimple followUser(int userId, int userIdToFollow) throws IOException, UserNotFoundException,
            UserAlreadyFollowedException {
        LOGGER.info("Inicio de accion Follow.");

        UserDTO follower = mtRepository.searchUser(userId);
        UserDTO followed = mtRepository.searchUser(userIdToFollow);

        if (Utils.searchIdInList(follower.getFollowed(), followed.getUserId())) {
            LOGGER.info("El usuario aun no seguia al otro usuario.");
            follower.getFollowed().add(userIdToFollow);
        } else
            throw new UserAlreadyFollowedException(followed.getUserId(), follower.getUserId());

        if (Utils.searchIdInList(followed.getFollowers(), follower.getUserId())) {
            LOGGER.info("El usuario aun no era seguido por el otro usuario.");
            followed.getFollowers().add(userId);
        } else
            throw new UserAlreadyFollowedException(followed.getUserId(), follower.getUserId());

        if (mtRepository.updateUsers())
            return new ResponseSimple(Constants.USER_FOLLOWED, HttpStatus.OK);
        else
            return new ResponseSimple(Constants.ERROR_USER_FOLLOWED, HttpStatus.BAD_REQUEST);
    }

    /**
     * Method to get the number of followers of a user
     *
     * @param userId {int} id of the user
     * @return {ResponseFollowersCount} response with the number of followers of the user with id "userId".
     * @author Daniel Alejandro López Hernández
     * @throws UserNotFoundException if the user is not found.
     */
    public ResponseFollowersCount countFollowers(int userId) throws UserNotFoundException {
        UserDTO user = mtRepository.searchUser(userId);
        ResponseFollowersCount response = new ResponseFollowersCount(user.getUserId(), user.getName(),
                user.getFollowers().size());
        LOGGER.info("Response generado: {}", response.toString());
        return response;
    }

    /**
     * Method to get the list of followers of a user.
     *
     * @param userId {int} id of the user
     * @return {ResponseListFollower} response with the list of users
     * @author Daniel Alejandro López Hernández
     * @throws UserNotFoundException if the user is not found.
     */
    public ResponseListFollower listFollowers(int userId, String order) throws UserNotFoundException {
        UserDTO user = mtRepository.searchUser(userId);
        UserListNode[] followersInfo = new UserListNode[user.getFollowers().size()];
        int index = 0;
        for (int i : user.getFollowers()) {
            UserListNode node = new UserListNode(i, mtRepository.searchUser(i).getName());
            followersInfo[index] = node;
            index++;
        }
        followersInfo = Utils.sorter(Arrays.asList(followersInfo.clone()), order).toArray(new UserListNode[0]);
        LOGGER.info("El array de seguidores es: {}", Arrays.toString(followersInfo));
        return new ResponseListFollower(userId, user.getName(), followersInfo);
    }

    /**
     * Method to get the list of followed sellers of a user.
     *
     * @param userId {int} id of the user
     * @return {ResponseListFollowed} response with the list of sellers
     * @author Daniel Alejandro López Hernández
     * @throws UserNotFoundException if the user is not found.
     */
    public ResponseListFollowed listFollowed(int userId, String order) throws UserNotFoundException {
        UserDTO user = mtRepository.searchUser(userId);
        UserListNode[] followedInfo = new UserListNode[user.getFollowed().size()];
        int index = 0;
        for (int i : user.getFollowed()) {
            UserListNode node = new UserListNode(i, mtRepository.searchUser(i).getName());
            followedInfo[index] = node;
            index++;
        }
        followedInfo = Utils.sorter(Arrays.asList(followedInfo.clone()), order).toArray(new UserListNode[0]);
        LOGGER.info("El array de vendedores seguidos es: {}", Arrays.toString(followedInfo));
        return new ResponseListFollowed(userId, user.getName(), followedInfo);
    }

    /**
     * Method that performs the registration of a publication and stores the information in the database.
     * @author Daniel Alejandro López Hernández
     * @param request {PostDTO} Model of the publication to be registered.
     * @return {ResponseSimple} Response with the publication record status.
     * @throws UserNotFoundException If the id of the user who makes the publication does not exist.
     * @throws PostIdAlreadyAssignedException If there is already a publication with the indicated id.
     * @throws DateNotValidException If the date does not meet the required characteristics.
     * @throws IOException If there is a problem updating the archive files.*/
    public ResponseSimple generatePost(PostDTO request) throws UserNotFoundException, PostIdAlreadyAssignedException,
            DateNotValidException, IOException {
        UserDTO user = mtRepository.searchUser(request.getUserId());
        Date datePost = request.getDate();

        if (mtRepository.searchPostId(request.getId_post())) {
            if (mtRepository.searchProductId(request.getDetail().getProduct_id()))
                if(mtRepository.registerProduct(request.getDetail()))
                    LOGGER.info("El producto {} se registro correctamente.", request.getDetail().getProduct_id());
            if (validateDate(datePost)) {
                if(mtRepository.registerPost(request)) {
                    LOGGER.info("El Post con id: {} fue registrado.", request.getId_post());
                    user.getPosts().add(request.getId_post());
                    if (mtRepository.updateUsers())
                        LOGGER.info("Se actualizo el archivo de usuarios");
                }
            } else
                throw new DateNotValidException(Constants.DATE_NOT_VALID, HttpStatus.BAD_REQUEST);
        } else
            throw new PostIdAlreadyAssignedException(Constants.POST_ID_ASSIGNED, HttpStatus.BAD_REQUEST);
        return new ResponseSimple(Constants.POST_GENERATED, HttpStatus.OK);
    }

    /**
     * Method that performs the validations of a date.
     * @author Daniel Alejandro López Hernández
     * @param postDate {Date} Date to be validated.
     * @return {boolean} true if the date is valid.*/
    private boolean validateDate(Date postDate) {
        Date actualDate = new Date();
        return actualDate.before(postDate);
    }

    /**
     * Method that returns a list with the most recent publications of the users followed by the user with id "userId".
     * @author Daniel Alejandro López Hernández
     * @param userId {int} id of the user
     * @return {ResponseRecentPosts} response with the list of the posts.
     * @throws UserNotFoundException if the id of the user doesn't exists.*/
    public ResponseRecentPosts getRecentPosts(int userId, String order) throws UserNotFoundException {
        LOGGER.info("Consultando las publicaciones de los vendedores seguidos por usuario con id: {}", userId);
        List<PostDTO> postsFollowed = mtRepository.searchUsersRecentPosts(userId);
        postsFollowed = Utils.postsSorter(postsFollowed, order);
        return new ResponseRecentPosts(userId, mtRepository.searchUser(userId).getName(), postsFollowed.toArray(new PostDTO[0]));
    }

    /**
     * Method to unfollow a user
     * @param userId         {int} id of the user who wants to follow other user.
     * @param userIdToUnFollow {int} id of the user who is going to be unfollowed.
     * @return {ResponseSimple} response with HttpStatus and message.
     * @throws IOException           if the singleto doesn't find the users file.
     * @throws UserNotFoundException if the user with one of the received ids doesn't exists.
     * @author Daniel Alejandro López Hernández
     */
    public ResponseSimple unFollowUser(int userId, int userIdToUnFollow) throws IOException, UserNotFoundException {
        LOGGER.info("Inicio de accion unFollow.");

        UserDTO follower = mtRepository.searchUser(userId);
        UserDTO followed = mtRepository.searchUser(userIdToUnFollow);

        if(!Utils.searchIdInList(follower.getFollowed(), userIdToUnFollow)){
            follower.getFollowed().remove(Integer.valueOf(userIdToUnFollow));
        }
        if(!Utils.searchIdInList(followed.getFollowers(), userId)){
            followed.getFollowers().remove(Integer.valueOf(userId));
        }
        if (mtRepository.updateUsers())
            return new ResponseSimple(Constants.USER_UNFOLLOWED, HttpStatus.OK);
        else
            return new ResponseSimple(Constants.ERROR_USER_FOLLOWED, HttpStatus.BAD_REQUEST);
    }
}
