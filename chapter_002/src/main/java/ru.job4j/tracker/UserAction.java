package ru.job4j.tracker;

public interface UserAction {
    /**
     * Should return the getKey number of the action.
     *
     * @return
     */
    int getKey();

    /**
     * Perform specified action with the passed input object and tracker.
     *
     * @param input
     * @param tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Should return info about action.
     *
     * @return
     */
    String info();


}
