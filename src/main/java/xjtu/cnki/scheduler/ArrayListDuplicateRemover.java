package xjtu.cnki.scheduler;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.component.DuplicateRemover;

/**
 * @基本功能:
 * @program:cnki
 * @author:peicc
 * @create:2020-05-25 18:38:03
 **/
public class ArrayListDuplicateRemover implements DuplicateRemover {
    @Override
    public boolean isDuplicate(Request request, Task task) {
        return false;
    }

    @Override
    public void resetDuplicateCheck(Task task) {

    }

    @Override
    public int getTotalRequestsCount(Task task) {
        return 0;
    }
}
