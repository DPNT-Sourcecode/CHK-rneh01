package befaster.solutions.HLO;

public class HelloSolution {
    public String hello(String friendName) {
        if (friendName.isEmpty())
            return "Hello, World!";
        else
            return "Hello, " + friendName + "!";
    }
}

