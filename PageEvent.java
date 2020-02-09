package BlackRock;

import javafx.event.Event;
import javafx.event.EventType;

public class PageEvent extends Event{

    public static final EventType<PageEvent> LEAVE_PAGE =
            new EventType<PageEvent>(PageEvent.ANY, "LEAVE_PAGE");

    public PageEvent(EventType<? extends Event> eventType) { super(eventType); }
}
