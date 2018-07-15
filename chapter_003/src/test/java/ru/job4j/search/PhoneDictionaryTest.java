package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
        persons = phones.find("sen");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
        persons = phones.find("487");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
        persons = phones.find("ryan");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenAbsentThenEmpty() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Goole");
        assertThat(persons.isEmpty(), is(true));
    }
}
