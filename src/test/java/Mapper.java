import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import de.ehmkah.projects.explicitmapper.test.domain.v1.Dog;

import javax.lang.model.element.Modifier;

/**
 * @author Michael Krausse (ehmkah)
 */
public class Mapper {

  public String create(Class<Dog> src, Class<de.ehmkah.projects.explicitmapper.test.domain.v2.Dog> target) {

    MethodSpec convert = MethodSpec.methodBuilder("convert")
            .returns(target)
            .addParameter(src, "src", Modifier.PUBLIC)
            .addModifiers(Modifier.STATIC)
            .build();


    TypeSpec typeSpec = TypeSpec.classBuilder("DogConverter")
            .addMethod(convert)
            .build();

    JavaFile javaFile = JavaFile.builder("converter", typeSpec)
            .build();

    return javaFile.toString();
  }
}
