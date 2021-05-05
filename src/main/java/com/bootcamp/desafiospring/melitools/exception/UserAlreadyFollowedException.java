package com.bootcamp.desafiospring.melitools.exception;

import com.bootcamp.desafiospring.melitools.utils.Constants;
import org.springframework.http.HttpStatus;

public class UserAlreadyFollowedException extends MeliToolsException{
    public UserAlreadyFollowedException(int idFollowed, int idFollower) {
        super(String.format(Constants.USER_ALREADY_FOLLOWED, idFollowed, idFollower), HttpStatus.OK);
    }
}
