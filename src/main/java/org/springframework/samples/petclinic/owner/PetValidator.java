package org.springframework.samples.petclinic.owner;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PetValidator implements Validator {

 @Override
 public boolean supports(Class<?> clazz) {
     return Pet.class.isAssignableFrom(clazz);
 }

 @Override
 public void validate(Object target, Errors errors) {
     Pet pet = (Pet) target;

     // 例: 禁止文字チェック
     if (pet.getName() != null && pet.getName().contains("!")) {
         errors.rejectValue("name", "pet.name.invalidChar", "名前に使用できない文字が含まれています。");
     }
 }
}
