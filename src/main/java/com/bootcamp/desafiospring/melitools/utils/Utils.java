package com.bootcamp.desafiospring.melitools.utils;

import com.bootcamp.desafiospring.melitools.entity.UserListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

    /**
     * Method to verify if an id already exists in a list.
     *
     * @param list {List<Inger>} list to search
     * @param id   {int} id to be search
     * @return {boolean} true if the id exists in the list
     * @author Daniel Alejandro López Hernández.
     */
    public static boolean searchIdInList(List<Integer> list, int id) {
        return !list.contains(id);
    }

    public static List<UserListNode> sorter(List<UserListNode> list, String order) {
        if (order.equals(Constants.ORDER_METHOD_NAME_ASC)) {
            LOGGER.info("Ordenamiento ascendente.");
            list = list.stream().sorted(Comparator.comparing(UserListNode::getUserName)).collect(Collectors.toList());
        } else {
            LOGGER.info("Ordenamiento descendente.");
            list = list.stream().sorted(Comparator.comparing(UserListNode::getUserName).reversed()).collect(Collectors.toList());
        }
        return list;
    }
}
