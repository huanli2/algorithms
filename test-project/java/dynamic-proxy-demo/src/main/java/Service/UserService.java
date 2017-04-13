package Service;

/**
 * Created by lih on 2017/3/30.
 */
public interface UserService {

    String getName(int id);

    Integer getAge(int id);

    Integer getNonAop(int id);
}
