package minera.porto.CarRental.controller;

import minera.porto.CarRental.dto.CarDTO;
import minera.porto.CarRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarDTO> findAllCars() {
        return carService.findAllCars();
    }

    @GetMapping("/{id}")
    public CarDTO findCarById(@PathVariable Long id) {
        return carService.findCarById(id);
    }

    @PostMapping("/")
    public CarDTO createCar(@RequestBody CarDTO carDTO) {
        return carService.saveCar(carDTO);
    }

    @PutMapping("/{id}")
    public CarDTO updateCar(@PathVariable Long id, @RequestBody CarDTO carDTO) {//missing dto
        carDTO.setId(id);
        return carService.saveCar(carDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
    }
}
