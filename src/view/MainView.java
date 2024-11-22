package view;

import exception.CustomException;
import model.DTO.PeopleDTO;
import model.entity.People;
import repository.Repository;
import utils.ValidateEmail;
import utils.ValidatePhone;


import java.util.List;
import java.util.Scanner;

public class MainView {

    private static Repository repository = new Repository();
    private static ValidateEmail validateEmail = new ValidateEmail();
    private static ValidatePhone  validatePhone = new ValidatePhone();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--------- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ------------");
            System.out.println("Chọn chức năng theo số (để tiếp tục) ");
            System.out.println("1. Xem danh sách ");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm ");
            System.out.println("6. Đọc từ file ");
            System.out.println("7. Ghi vào file ");
            System.out.println("8. Thoát ");
            System.out.println("Chọn chức năng: ");
            int choice = inputChoice();
            switch (choice) {
                case 1:
                    menu();
                    break;
                case 2:
                    System.out.println("Quản lý giảng viên");
                    break;
                case 3:
                    return;
            }
        }

    }
        public static void menu() {
            int choice;
            List<People> Peoples;
            People People;
            while (true) {
                System.out.println("Menu quản lý danh bạ");
                System.out.println("1. Hiển thị danh sách");
                System.out.println("2. Thêm mới");
                System.out.println("3. Sửa thông tin");
                System.out.println("4. Xóa");
                System.out.println("5. Tìm kiếm theo tên");
                System.out.println("6. Đọc từ file ");
                System.out.println("7. Ghi vào file");
                System.out.println("8. Quay lại");
                System.out.print("Nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                choice = inputChoice();
                switch (choice) {
                    case 1:
                        Peoples = repository.getAll();
                        if(Peoples == null || Peoples.isEmpty()) {
                            System.out.println("DANH SÁCH DANH BẠ HIỆN TẠI ĐANG RỖNG");
                            break;
                        }
                        display(Peoples);
                        break;
                    case 2:
                       People people = inputPeople();
                        repository.save(people);
                        System.out.println("Thêm mới thành công");
                        break;
                    case 3:
                        System.out.println("Sửa thông tin");
                        updatePeople();
                        break;
                    case 4:
                        System.out.println("Xóa");
                        deletePeople();
                        break;
                    case 5:
                        System.out.println("Tìm kiếm theo tên");
                        String name = scanner.nextLine();
                        Peoples = repository.findByName(name);
                        display(Peoples);
                        break;
                    case 6:
                        Peoples = repository.getAll();
                        if(Peoples == null || Peoples.isEmpty()) {
                            System.out.println("DANH SÁCH DANH BẠ HIỆN TẠI ĐANG RỖNG");
                            break;
                        }
                        display(Peoples);
                        return;
                    case 7:
                        System.out.println("NULL");
                        return;
                    case 8:
                        return;
                }
            }

        }

        private static People inputPeople() {

            Scanner scanner = new Scanner(System.in);
            boolean isExistid = true;
            long phone = 0;
            while (isExistid) {
                try {
                    System.out.print("Mời bạn nhập số điện thoại: ");
                    phone = Long.parseLong(scanner.nextLine());
                    boolean isValid = validatePhone.matches(phone);
                    if(!isValid) {
                        System.out.println("Số điện thoại: " + phone + " không hợp lệ, Vui lòng nhập lại! ");
                        continue;
                    }
                    People People = repository.findByPhone(phone);
                    if (People == null) {
                        isExistid = false;
                        break;
                    } else {
                        System.out.println("Số điện thoại đã tồn tại, vui lòng chọn lại! ");
                    }
                } catch (NumberFormatException e) {
                    CustomException.numberFormatException(e);
                }
            }

            String name;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập tên: ");
                    name = scanner.nextLine();
                    CustomException.checkEmptyString(name);
                    break;
                } catch (NumberFormatException e) {
                    CustomException.numberFormatException(e);
                }
            }

            String email;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập email: ");
                    email = scanner.nextLine();
                    boolean isValid = validateEmail.matches(email);
                    if(!isValid) {
                        System.out.println("Email: " + email + " không hợp lệ, Vui lòng nhập lại! ");
                        continue;
                    }
                    CustomException.checkEmptyString(email);
                    break;
                } catch (NumberFormatException e) {
                    CustomException.numberFormatException(e);
                }
            }

            String address;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập địa chỉ: ");
                    address = scanner.nextLine();
                    CustomException.checkEmptyString(address);
                    break;
                } catch (NumberFormatException e) {
                    CustomException.numberFormatException(e);
                }
            }


            String gender;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập giới tính: ");
                    gender = scanner.nextLine();
                    CustomException.checkEmptyString(gender);
                    break;
                } catch (NumberFormatException e) {
                    CustomException.numberFormatException(e);
                }
            }

            String birthday;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập ngày sinh: ");
                    birthday = scanner.nextLine();
                    CustomException.checkEmptyString(birthday);
                    break;
                } catch (NumberFormatException e) {
                    CustomException.numberFormatException(e);
                }
            }

            String group;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập nhóm: ");
                    group = scanner.nextLine();
                    CustomException.checkEmptyString(group);
                    break;
                } catch (NumberFormatException e) {
                    CustomException.numberFormatException(e);
                }
            }
            return new People(phone, name, email, address, gender, birthday, group);
        }

        public static void display(List<People> Peoples) {
            System.out.println("Hiển thị danh sách danh bạ");
            for (People People : Peoples) {
                System.out.println(People);
            }
        }

        private static int inputChoice() {
            Scanner scanner = new Scanner(System.in);
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai lựa chọn. Mời bạn nhập lại");
            } catch (Exception e) {
                System.out.println("Lỗi khác");
            }
            return 0;
        }

        public static void deletePeople() {
            Scanner scanner = new Scanner(System.in);
            long id = Integer.parseInt(scanner.nextLine());
            repository.remove(id);
            System.out.println("Đã xóa thành công 1 số điện thoại");
        }

        public static PeopleDTO peopleDto() {
            Scanner scanner = new Scanner(System.in);
            String name;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập tên: ");
                    name = scanner.nextLine();
                    CustomException.checkEmptyString(name);
                    break;
                } catch (NumberFormatException e) {
                    CustomException.numberFormatException(e);
                }
            }

            String address;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập địa chỉ update: ");
                    address = scanner.nextLine();
                    CustomException.checkEmptyString(address);
                    break;
                } catch (NumberFormatException e) {
                    CustomException.numberFormatException(e);
                }
            }

            String email;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập email: ");
                    email = scanner.nextLine();
                    boolean isValid = validateEmail.matches(email);
                    if(!isValid) {
                        System.out.println("Email: " + email + " không hợp lệ, Vui lòng nhập lại! ");
                        continue;
                    }
                    CustomException.checkEmptyString(email);
                    break;
                } catch (NumberFormatException e) {
                    CustomException.numberFormatException(e);
                }
            }

            String gender;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập lớp update: ");
                    gender = scanner.nextLine();
                    CustomException.checkEmptyString(gender);
                    break;
                } catch (NumberFormatException e) {
                    CustomException.numberFormatException(e);
                }
            }

            String birthday;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập ngày sinh: ");
                    birthday = scanner.nextLine();
                    CustomException.checkEmptyString(birthday);
                    break;
                } catch (NumberFormatException e) {
                    CustomException.numberFormatException(e);
                }
            }

            String group;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập nhóm: ");
                    group = scanner.nextLine();
                    CustomException.checkEmptyString(group);
                    break;
                } catch (NumberFormatException e) {
                    CustomException.numberFormatException(e);
                }
            }
            return new PeopleDTO( name,  email,  address,  gender,  birthday,  group);
        }

        public static void updatePeople() {
            System.out.println("Vui lòng nhập số điện thoại cần update thông tin");
            Scanner scanner = new Scanner(System.in);
            long phone = Integer.parseInt(scanner.nextLine());
            People People = repository.findByPhone(phone);
            if (People == null) {
                System.out.println("Phone not found !");
                menu();
            }
            System.out.println(People);
            PeopleDTO peopleInfo = peopleDto();
            repository.updateInfo(phone, peopleInfo);
            System.out.println("Update People Success");
        }



}
