package net.medinacom.roomwordsample;

abstract class Repository {

    public static void runAsync(RepoTask task) {
        new Thread(() -> task.apply()).start();
    }

    interface RepoTask {
        void apply();
    }
}
