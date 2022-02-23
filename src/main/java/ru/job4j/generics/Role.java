package ru.job4j.generics;

import java.util.Objects;

public class Role extends Base {

    private String post;

    public Role(String id, String name) {
        super(id);
        this.post = name;
    }

    public String getPost() {
        return post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(post, role.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), post);
    }

    @Override
    public String toString() {
        return "Role{" + "id='"
                + post + '\'' + '}';
    }
}
