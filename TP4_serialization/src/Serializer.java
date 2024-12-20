package com.example.coach.tools;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe qui permet de serialiser et deserialiser des objets
 * @author Mahdi Hafsi
 */

public abstract class Serializer {
    /**
     * serialization d'un objet
     * @param filename
     * @param object
     * @param context
     */
    public static void serialize(String filename, Object object , Context context){
        try {
            FileOutputStream file = context.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream oos;
            try{
                oos = new ObjectOutputStream(file);
                oos.writeObject(object);
                oos.flush();
                oos.close();
            }catch (IOException e){
                //erreur de serialisation
                e.printStackTrace();
            }
        } catch ( FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * deserialisation d'un objet
     * @param filename
     * @param context
     * @return objet
     */
    public static Object deserializer(String filename , Context context){
        try {
            FileInputStream file = context.openFileInput(filename);
            ObjectInputStream ois ;
            try{
                ois = new ObjectInputStream(file);
                try {
                    Object object = ois.readObject();
                    ois.close();
                    return object;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
