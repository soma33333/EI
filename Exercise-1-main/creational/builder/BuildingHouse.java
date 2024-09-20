package creational.builder;
class House {
    private String roof;
    private String windows;
    private String doors;
    private String garage;

    private House(HouseBuilder builder) {
        this.roof = builder.roof;
        this.windows = builder.windows;
        this.doors = builder.doors;
        this.garage = builder.garage;
    }

    @Override
    public String toString() {
        return "House [roof=" + roof + ", windows=" + windows + ", doors=" + doors + ", garage=" + garage + "]";
    }

    public static class HouseBuilder {
        private String roof;
        private String windows;
        private String doors;
        private String garage;

        public HouseBuilder setRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public HouseBuilder setWindows(String windows) {
            this.windows = windows;
            return this;
        }

        public HouseBuilder setDoors(String doors) {
            this.doors = doors;
            return this;
        }

        public HouseBuilder setGarage(String garage) {
            this.garage = garage;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}

public class BuildingHouse{
    public static void main(String[] args) {
        House luxuryHouse = new House.HouseBuilder()
                .setRoof("Luxury Roof")
                .setWindows("Large Windows")
                .setDoors("Wooden Doors")
                .setGarage("2-Car Garage")
                .build();

        House smallHouse = new House.HouseBuilder()
                .setRoof("Simple Roof")
                .setWindows("Small Windows")
                .setDoors("Basic Doors")
                .build();

        System.out.println(luxuryHouse);
        System.out.println(smallHouse);
    }
}
