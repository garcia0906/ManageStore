package co.edu.umanizales.tads.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
    public class ListDEController {
    private void DeletePet(String name) {
    }
        @DeleteMapping("/pets/{name}")
        public void deletePetByName(@PathVariable("name") String name) {
            DeletePet(name);
        }

}
