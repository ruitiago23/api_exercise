package minera.porto.CarRental.service;

import minera.porto.CarRental.dto.CarDTO;
import minera.porto.CarRental.entity.Car;
import minera.porto.CarRental.repository.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarDTO> findAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CarDTO findCarById(Long id) {
        return carRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public CarDTO saveCar(CarDTO carDTO) {
        Car car = convertToEntity(carDTO);
        car = carRepository.save(car);
        return convertToDTO(car);
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    private CarDTO convertToDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        BeanUtils.copyProperties(car, carDTO);
        return carDTO;
    }

    private Car convertToEntity(CarDTO carDTO) {
        Car car = new Car();
        BeanUtils.copyProperties(carDTO, car);
        return car;
    }
}
