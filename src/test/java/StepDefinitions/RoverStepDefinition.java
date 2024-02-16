package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.testng.Assert.assertEquals;
import RoverPackage.Rover;


public class RoverStepDefinition {
        private Rover rover;

        @Given("a plateau with upper-right coordinates {int}, {int}")
        public void setPlateau(int i, int j) {
            // No action needed, initialization is done in Given step
        }

        @Given("a rover at position {int}, {int}, {string}")
        public void initializeRover(int x, int y, String direction) {
            rover = new Rover();
            rover.setPosition(x, y, directionToInteger(direction));
        }

        @When("the rover's position is initialized")
        public void initializePosition() {
            // No action needed, initialization is done in Given step
        }

        @When("the rover moves with commands {string}")
        public void move(String commands) {
            rover.process(commands);
        }

        @Then("the rover should be at position {int}, {int}, facing {string}")
        public void checkXY(int x, int y, String direction) {
            assertEquals(x, rover.x.intValue());
            assertEquals(y, rover.y.intValue());
            assertEquals(directionToInteger(direction), rover.facing);
        }

        private Integer directionToInteger(String direction) {
            switch (direction) {
                case "N": return Rover.N;
                case "E": return Rover.E;
                case "S": return Rover.S;
                case "W": return Rover.W;
                default: throw new IllegalArgumentException("Invalid direction: " + direction);
            }
        }


}
