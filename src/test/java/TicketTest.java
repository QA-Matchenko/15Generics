import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    public void testSortOutNewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Saigon", "Manila", 23000, 13, 15);
        Ticket ticket2 = new Ticket("Sanya", "Moscow", 33000, 10, 14);
        Ticket ticket3 = new Ticket("Semey", "Astana", 3000, 9, 11);
        Ticket ticket4 = new Ticket("Sydney", "SPB", 53000, 12, 15);
        Ticket ticket5 = new Ticket("Saigon", "Manila", 99000, 12, 16);
        Ticket ticket6 = new Ticket("Surgut", "Male", 123000, 3, 5);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("Saigon", "Manila");
        Ticket[] expected = {ticket1, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOutNoTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Saigon", "Manila", 23000, 13, 15);
        Ticket ticket2 = new Ticket("Sanya", "Moscow", 33000, 10, 14);
        Ticket ticket3 = new Ticket("Semey", "Astana", 3000, 9, 11);
        Ticket ticket4 = new Ticket("Sydney", "SPB", 53000, 12, 15);
        Ticket ticket5 = new Ticket("Saigon", "Manila", 99000, 12, 16);
        Ticket ticket6 = new Ticket("Surgut", "Male", 123000, 3, 5);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("Saigon", "Astana");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOutOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Saigon", "Manila", 23000, 13, 15);
        Ticket ticket2 = new Ticket("Sanya", "Moscow", 33000, 10, 14);
        Ticket ticket3 = new Ticket("Semey", "Astana", 3000, 9, 11);
        Ticket ticket4 = new Ticket("Sydney", "SPB", 53000, 12, 15);
        Ticket ticket5 = new Ticket("Saigon", "Manila", 99000, 12, 16);
        Ticket ticket6 = new Ticket("Surgut", "Male", 123000, 3, 5);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("Sydney", "SPB");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOutWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Saigon", "Manila", 23000, 13, 15);
        Ticket ticket2 = new Ticket("Sanya", "Moscow", 33000, 10, 14);
        Ticket ticket3 = new Ticket("Semey", "Astana", 3000, 9, 11);
        Ticket ticket4 = new Ticket("Sydney", "SPB", 53000, 12, 15);
        Ticket ticket5 = new Ticket("Saigon", "Manila", 99000, 12, 16);
        Ticket ticket6 = new Ticket("Surgut", "Male", 123000, 3, 5);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] actual = manager.search("Saigon", "Manila");
        Ticket[] expected = {ticket1, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOutNoTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Saigon", "Manila", 23000, 13, 15);
        Ticket ticket2 = new Ticket("Sanya", "Moscow", 33000, 10, 14);
        Ticket ticket3 = new Ticket("Semey", "Astana", 3000, 9, 11);
        Ticket ticket4 = new Ticket("Sydney", "SPB", 53000, 12, 15);
        Ticket ticket5 = new Ticket("Saigon", "Manila", 99000, 12, 16);
        Ticket ticket6 = new Ticket("Surgut", "Male", 123000, 3, 5);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] actual = manager.search("Saigon", "SPB", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOutOneTicketWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Saigon", "Manila", 23000, 13, 15);
        Ticket ticket2 = new Ticket("Sanya", "Moscow", 33000, 10, 14);
        Ticket ticket3 = new Ticket("Semey", "Astana", 3000, 9, 11);
        Ticket ticket4 = new Ticket("Sydney", "SPB", 53000, 12, 15);
        Ticket ticket5 = new Ticket("Saigon", "Manila", 99000, 12, 16);
        Ticket ticket6 = new Ticket("Surgut", "Male", 123000, 3, 5);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] actual = manager.search("Semey", "Astana", comparator);
        Ticket[] expected = {ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

}