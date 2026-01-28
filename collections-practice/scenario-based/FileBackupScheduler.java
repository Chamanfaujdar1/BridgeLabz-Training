// package collections_practice.scenario_based;

import java.util.*;

class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

class BackupTask implements Comparable<BackupTask> {
	private String folderPath;
    private int priority;

    public BackupTask(String folderPath, int priority) throws InvalidBackupPathException {
        if (folderPath == null || folderPath.trim().isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path!");
        }
        this.folderPath = folderPath;
        this.priority = priority;
    }

    public String getFolderPath() {
        return folderPath;
    }
    
    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(BackupTask other) {
        return Integer.compare(other.priority, this.priority);
    }
    
    public void executeBackup() {
        System.out.println("Backing up folder: " + folderPath + 
                           " | Priority: " + priority);
    }
}

public class FileBackupScheduler {

	public static void main(String[] args) {
		PriorityQueue<BackupTask> queue = new PriorityQueue<>();

        try {
            queue.add(new BackupTask("/system/config", 5));
            queue.add(new BackupTask("/user/documents", 2));
            queue.add(new BackupTask("/media/photos", 3));
        } 
        catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Executing Backup Tasks\n");

        while (!queue.isEmpty()) {
            BackupTask task = queue.poll();
            task.executeBackup();
        }
	}

}
