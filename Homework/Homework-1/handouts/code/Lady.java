class Animal {
    private String name;

    Animal(String name) {
        this.name = name;
    }

    public void enjoy() {
        System.out.println("叫声......");
    }
}

class MyCat extends Animal {
    private String eyesColor;

    MyCat(String n, String c) {
        super(n);
        eyesColor = c;
    }

    public void enjoy() {
        System.out.println("猫叫声......");
    }
}

class Dog extends Animal {
    private String furColor;

    Dog(String n, String c) {
        super(n);
        furColor = c;
    }

    public void enjoy() {
        System.out.println("狗叫声......");
    }
}

class Lady {
    private String name;
    private Animal pet;

    Lady(String name, Animal pet) {
        this.name = name;
        this.pet = pet;
    }

    public void myPetEnjoy() {
        pet.enjoy();
    }


    public static void main(String[] args){
        MyCat c = new MyCat("catname", "blue");
        Dog d = new Dog("dogname", "black");
        Lady l1 = new Lady("l1",c);
        Lady l2 = new Lady("l2", d);
        l1.myPetEnjoy();
        l2.myPetEnjoy();
    }
    
}