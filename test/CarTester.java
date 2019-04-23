import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarTester {

  private Car mCar;

  @Before
  public void setUp() {
    mCar = new Car();
  }

  @Test
  public void constructor_whenCreated_shouldBeTurnedOff() {
    assertFalse(mCar.isTurnedOn());
  }

  @Test
  public void turnOn_whenOff_shouldPass() {
    mCar.turnOn();
    assertTrue(mCar.isTurnedOn());
  }

  @Test(expected = IllegalStateException.class)
  public void turnOn_whenOn_shouldThrow() {
    mCar.turnOn();
    mCar.turnOn(); // should throw exception
  }

  @Test(expected = IllegalStateException.class)
  public void turnOff_whenOff_shouldThrow() {
    assertFalse(mCar.isTurnedOn());
    mCar.turnOff();
  }

  @Test
  public void turnOff_whenOn_shouldPass() {
    mCar.turnOn();
    mCar.turnOff();
    assertFalse(mCar.isTurnedOn());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void fly_shouldThrow() {
    mCar.fly();
  }
}