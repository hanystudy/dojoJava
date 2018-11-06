package name.hanyi.calendar.api;

import java.io.Console;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class InternationalTimeCommand implements CalendarCommand {

    private final List<String> zoneList;

    public InternationalTimeCommand() {
        Set<String> zoneSet = ZoneId.getAvailableZoneIds();
        zoneList = new ArrayList<>(zoneSet);
        Collections.sort(zoneList);
    }

    @Override
    public String getName() {
        return "it";
    }

    @Override
    public void execute(Console console) {
        ZonedDateTime time = ZonedDateTime.now();
        for (String zone : zoneList) {
            ZoneId zoneId = ZoneId.of(zone);
            console.format("%s\n", time.withZoneSameInstant(zoneId));
        }
    }

    @Override
    public String getHelp() {
        return "print international time";
    }
}
