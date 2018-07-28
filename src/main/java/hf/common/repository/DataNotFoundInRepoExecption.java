package hf.common.repository;

/**
 * Created by AnkitNigam on 07/27/2018.
 */
public class DataNotFoundInRepoExecption extends Exception {
    public DataNotFoundInRepoExecption() {
        super("Element not found in repository");
    }

    public DataNotFoundInRepoExecption(String message) {
        super(message);
    }
}
