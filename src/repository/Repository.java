package repository;

import model.DTO.PeopleDTO;
import model.entity.People;
import service.IOFile.IOFile;
import service.IPeoleService;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IPeoleService {
//    private static List<People> peopleList = new ArrayList<>();
    private  static IOFile ioFile = new IOFile();
    @Override
    public List<People> getAll() {
        List<People> Peoples = ioFile.readFile();
        if(Peoples == null || Peoples.isEmpty()) {
            return null;
        }
        return Peoples;
    }

    @Override
    public void save(People p) {
        List<People> peoples = getAll();
        peoples.add(p);
        ioFile.writeFile(peoples,false);
    }

    @Override
    public void update(long phone, People s) {

    }


    @Override
    public void updateInfo(long phone, PeopleDTO peopleDTO) {
        List<People> peopleList = getAll();
        if(peopleList == null || peopleList.isEmpty()) {
            return;
        }
        for (People data : peopleList) {
            if (phone == data.getPhone()) {
                data.setName(peopleDTO.getName());
                data.setEmail(peopleDTO.getEmail());
                data.setAddress(peopleDTO.getAddress());
                data.setGender(peopleDTO.getGender());
                data.setGroup(peopleDTO.getGroup());
                data.setBirthday(peopleDTO.getBirthday());
            }
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        }
        ioFile.writeFile(peopleList, false);
    }

    @Override
    public void remove(long id) {
        List<People> PeoplesList = getAll();
        if(PeoplesList == null && PeoplesList.isEmpty()) {
            return;
        }
        for (People employee : PeoplesList) {
            if (employee.getPhone() == id) {
                PeoplesList.remove(employee);
                break;
            }
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        }
        ioFile.writeFile(PeoplesList,false);
    }

    @Override
    public People findByPhone(long phone) {
        List<People> Peoples = getAll();
        for (People People: Peoples) {
            if(People.getPhone() == phone) {
                return People;
            }
        }
        return null;

    }

    @Override
    public List<People> findByName(String name) {
        List<People> peopleList = getAll();
        List<People> temp = new ArrayList<>();
        for (People people : peopleList) {
            String nameInput = name.toLowerCase();
            String nameData = people.getName().toLowerCase();
            if (nameData.contains(nameInput)) {
                temp.add(people);
            }
        }
        return temp;
    }

}

