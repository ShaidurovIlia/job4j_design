package ru.job4j.serialization;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serial;
import java.io.Serializable;

@XmlRootElement(name = "passport")
public class Passport implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @XmlAttribute
    private int number;

    private Dog dog;

    public Passport() { }

    public Passport(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Passport{"
                + "number="
                + number + '}';
    }
}
