package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.ReadOnlyEventStorage;
import seedu.address.model.EventStorage;
import seedu.address.model.VolunteerStorage;
import seedu.address.model.ReadOnlyVolunteerStorage;
import seedu.address.model.event.Event;
import seedu.address.model.person.*;
import seedu.address.model.person.Volunteer;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    // To be updated
    public static Event[] getSampleEvents() {
//        return new Volunteer[] {
//                new Volunteer(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
//                        new Address("Blk 30 Geylang Street 29, #06-40"),
//                        getTagSet("friends")),
//                new Volunteer(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
//                        new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
//                        getTagSet("colleagues", "friends")),
//                new Volunteer(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
//                        new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
//                        getTagSet("neighbours")),
//                new Volunteer(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
//                        new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
//                        getTagSet("family")),
//                new Volunteer(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
//                        new Address("Blk 47 Tampines Street 20, #17-35"),
//                        getTagSet("classmates")),
//                new Volunteer(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
//                        new Address("Blk 45 Aljunied Street 85, #11-31"),
//                        getTagSet("colleagues"))
//        };
        return new Event[]{};
    }

    public static ReadOnlyEventStorage getSampleEventStorage() {
        EventStorage sampleAb = new EventStorage();
        for (Event sampleEvent : getSampleEvents()) {
            sampleAb.addEvent(sampleEvent);
        }
        return sampleAb;
    }
    public static Volunteer[] getSampleVolunteers() {
        return new Volunteer[] {
            new Volunteer(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends")),
            new Volunteer(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends")),
            new Volunteer(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours")),
            new Volunteer(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family")),
            new Volunteer(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates")),
            new Volunteer(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"))
        };
    }

    public static ReadOnlyVolunteerStorage getSampleVolunteerStorage() {
        VolunteerStorage sampleAb = new VolunteerStorage();
        for (Volunteer sampleVolunteer : getSampleVolunteers()) {
            sampleAb.addPerson(sampleVolunteer);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
