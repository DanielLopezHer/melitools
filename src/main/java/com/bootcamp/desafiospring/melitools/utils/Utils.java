package com.bootcamp.desafiospring.melitools.utils;

import com.bootcamp.desafiospring.melitools.dto.UserDTO;

import java.util.List;

public class Utils {
    /**
     *Method to verify if an id already exists in a list.
     * @author Daniel Alejandro López Hernández.
     * @param list {List<Inger>} list to search
     * @param id {int} id to be search
     * @return {boolean} true if the id exists in the list*/
    public static boolean searchIdInList(List<Integer> list, int id){
        return !list.contains(id);
    }
}
