class ParkingSystem {
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        // Index 1 = big, 2 = medium, 3 = small
        slots = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        return slots[carType]-- > 0;
    }
}
