package ru.javaxblog.time;

import javax.swing.*;

/**
 * Created by Алмаз on 16.03.2015.
 */
public class Time {
    public static void main(String[] args){
        String dt=new java.text.SimpleDateFormat(("hh:mm aaa")).format(java.util.Calendar.getInstance().getTime());
        JOptionPane.showMessageDialog(null, "Текущее время: " + dt, "Время", JOptionPane.INFORMATION_MESSAGE);
    }
}
