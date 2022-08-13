package com.steven.design.pattern.creational.singleton;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Scanner;

@Slf4j
public class JDBCSingletonDemo {
    static int count = 1;
    static int choice;

    public static void main(String[] args) throws IOException {

        JDBCSingleton jdbc = JDBCSingleton.getInstance();


        Scanner scanner = new Scanner(System.in);
        do {
            log.info("DATABASE OPERATIONS \n " +
                    "--------------------- \n" +
                    "1. Insertion \n" +
                    "2. View      \n" +
                    "3. Delete    \n" +
                    "4. Update    \n" +
                    "5. Exit      \n" +
                    "Please enter the choice what you want to perform in the database:");
            choice = scanner.nextInt();
            switch (choice) {

                case 1: {
                    log.info("Enter the username you want to insert data into the database:");
                    String username = scanner.nextLine();
                    log.info("Enter the password you want to insert data into the database: ");
                    String password = scanner.nextLine();

                    try {
                        int i = jdbc.insert(username, password);
                        if (i > 0) {
                            log.info("{} Data has been inserted successfully", count++);
                        } else {
                            log.warn("Data has not been inserted ");
                        }

                    } catch (Exception e) {
                        log.error("insert exception:", e);
                    }

                    log.info("Press Enter key to continue...");
                    System.in.read();

                }//End of case 1
                break;
                case 2: {
                    log.info("Enter the username : ");
                    String username = scanner.nextLine();

                    try {
                        jdbc.view(username);
                    } catch (Exception e) {
                        log.error("exception:", e);
                    }
                    log.info("Press Enter key to continue...");
                    System.in.read();

                }//End of case 2
                break;
                case 3: {
                    log.info("Enter the userid,  you want to delete: ");
                    int userid = scanner.nextInt();

                    try {
                        int i = jdbc.delete(userid);
                        if (i > 0) {
                            log.info("{} Data has been deleted successfully", count++);
                        } else {
                            log.warn("Data has not been deleted");
                        }

                    } catch (Exception e) {
                        log.error("exception:", e);
                    }
                    log.info("Press Enter key to continue...");
                    System.in.read();

                }//End of case 3
                break;
                case 4: {
                    log.info("Enter the username,  you want to update: ");
                    String username = scanner.nextLine();
                    log.info("Enter the new password ");
                    String password = scanner.nextLine();

                    try {
                        int i = jdbc.update(username, password);
                        if (i > 0) {
                            log.info("{} Data has been updated successfully", count++);
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    log.info("Press Enter key to continue...");
                    System.in.read();

                }// end of case 4
                break;

                default:
                    return;
            }

        } while (choice != 4);
    }
}
