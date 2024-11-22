package service;

import model.DTO.PeopleDTO;
import model.entity.People;

public interface IPeoleService extends IService<People>{
    void updateInfo(long phone, PeopleDTO s);
}
