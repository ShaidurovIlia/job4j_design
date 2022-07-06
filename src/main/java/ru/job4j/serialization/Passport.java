package ru.job4j.serialization;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "passport")
public class Passport {
    @XmlAttribute
    private int number;

    public Passport() { }

    public Passport(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport{"
                + "number="
                + number + '}';
    }
}
