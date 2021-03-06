package  OSRS.FIsher.Actions;

import OSRS.FIsher.Utils.Task;
import OSRS.FIsher.Utils.Variables;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

import javax.sound.midi.SysexMessage;

public class Bank extends Task {
    public Bank(ClientContext arg0) {
        super(arg0);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().count() > 27 && Variables.bankArea.contains(ctx.players.local().tile());
    }

    @Override
    public void execute() {
        if (ctx.bank.opened()) {
            Variables.status = "Banking";
            int count = ctx.inventory.select().id(Variables.fishID).count();
            for (int i : Variables.fishID) {
                ctx.bank.deposit(i, count);
            }
        } else {
            if (ctx.bank.inViewport()) {
                Variables.status = "Opening bank";
                ctx.bank.open();
            }
            else {
                Variables.status = "Turning camera to nearest bank";
                ctx.camera.turnTo(ctx.bank.nearest());
            }
        }
    }
}
