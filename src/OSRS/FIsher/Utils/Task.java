package OSRS.FIsher.Utils;

import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;

public abstract class Task extends ClientAccessor {
    public Task(ClientContext arg0) {
        super(arg0);
    }

    public abstract boolean activate();
    public abstract void execute();
}
