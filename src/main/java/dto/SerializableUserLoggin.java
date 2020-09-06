package dto;

import entity.User;

import java.io.*;

import static service.RegisterAndLogginService.userWithLoggin;

public class SerializableUserLoggin {
    /**
     * Serializable userWithLoggin
     */
    public static void SerializableUserWithLoggin() throws IOException {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("userWithLogginFile.bin"))){
            outputStream.writeObject(userWithLoggin);
        }
    }
    /**
     * Read Serializable userWithLoggin
     */
    public static void ReadSerializableObject() throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("userWithLogginFile.bin"))){
            User user = (User) objectInputStream.readObject();
            System.out.println(user.toString());
        }
    }
}
