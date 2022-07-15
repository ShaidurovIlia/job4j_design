package ru.job4j.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "dog")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dog {
    @XmlAttribute
    private boolean purebred;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private String name;

    private Passport passport;
    @XmlElementWrapper
    private String[] colors;

    public Dog() { }

    public Dog(boolean purebred, int age, String name, Passport passport, String... colors) {
        this.purebred = purebred;
        this.age = age;
        this.name = name;
        this.passport = passport;
        this.colors = colors;
    }

    public boolean isPurebred() {
        return purebred;
    }

    public int getAge() {
        return age;

    }

    public String getName() {
        return name;
    }

    public Passport getPassport() {
        return passport;
    }

    public String[] getColors() {
        return colors;
    }

    @Override
    public String toString() {
        return "Dog{" + "purebred="
                + purebred + ", age="
                + age + ", name='"
                + name + '\'' + ", passport="
                + passport + ", colors="
                + Arrays.toString(colors)
                + '}';
    }

    public static void main(String[] args) throws  JAXBException {
        final Dog dog = new Dog(true, 3, "Lord",
                new Passport(1418999966), "Black", "White");
        JAXBContext context = JAXBContext.newInstance(Dog.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(dog, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (Exception o) {
            o.printStackTrace();
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Dog rsl = (Dog) unmarshaller.unmarshal(reader);
            System.out.println(rsl);
        }
    }
}