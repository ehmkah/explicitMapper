import de.ehmkah.projects.explicitmapper.test.domain.v1.Dog;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Krausse (ehmkah)
 */
public class MapperTest {

  @Test
  public void testMapper() {
    Mapper mapper = new Mapper();

    String actual = mapper.create(Dog.class, de.ehmkah.projects.explicitmapper.test.domain.v2.Dog.class);

    Assert.assertEquals("package converter;\n" +
            "\n" +
            "class DogConverter {\n" +
            "}\n", actual);

  }


}
