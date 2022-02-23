package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindTheRoleId() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Manager"));
        Role result = store.findById("1");
        assertThat(result.getPost(), is("Manager"));
    }

    @Test
    public void whenAddAndFindTheRoleNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Manager"));
        Role result = store.findById("5");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateTheRolePost() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Manager"));
        store.add(new Role("1", "Developer"));
        Role result = store.findById("1");
        assertThat(result.getPost(), is("Developer"));
    }

    @Test
    public void whenReplaceRolePostIsDeveloper() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Manager"));
        store.replace("1", new Role("1", "Developer"));
        Role result = store.findById("1");
        assertThat(result.getPost(), is("Developer"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Manager"));
        store.replace("5", new Role("5", "Developer"));
        Role result = store.findById("1");
        assertThat(result.getPost(), is("Manager"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Manager"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteRoleThenRoleIsManger() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Manager"));
        store.delete("5");
        Role result = store.findById("1");
        assertThat(result.getPost(), is("Manager"));
    }
}