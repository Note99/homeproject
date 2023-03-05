public class Room implements Comparable<Room> {
    private int roomNumber;
    private int capacity;
    private boolean isOccupied;

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.isOccupied = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public boolean occupy() {
        if (isOccupied) {
            return false;
        } else {
            isOccupied = true;
            return true;
        }
    }

    public boolean vacate() {
        if (!isOccupied) {
            return false;
        } else {
            isOccupied = false;
            return true;
        }
    }

    @Override
    public int compareTo(Room otherRoom) {
        return Integer.compare(this.roomNumber, otherRoom.roomNumber);
    }
}
