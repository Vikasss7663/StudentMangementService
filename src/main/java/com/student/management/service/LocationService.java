package com.student.management.service;

import com.student.management.dtos.LocationDto;
import com.student.management.model.Location;
import com.student.management.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    
    private final LocationRepository locationRepository;

    public List<LocationDto> getLocations() {
        List<LocationDto> locationDtos = new ArrayList<>();
        locationRepository.findAll().forEach(it -> locationDtos.add(getLocationDtoInstance(it)));
        return locationDtos;
    }

    public LocationDto getLocation(int id) {
        return getLocationDtoInstance(locationRepository.findById(id).get());
    }

    public LocationDto addLocation(LocationDto locationDto) {
        Location location = getLocationInstanceFromDto(locationDto);
        return getLocationDtoInstance(locationRepository.save(location));
    }

    public LocationDto updateLocation(LocationDto locationDto) {
        Location location = getLocationInstanceFromDto(locationDto);
        return getLocationDtoInstance(locationRepository.save(location));
    }

    public void deleteLocation(int id) {
        locationRepository.deleteById(id);
    }

    private Location getLocationInstanceFromDto(LocationDto locationDto) {
        Location location = new Location();
        location.setLocationId(locationDto.getLocationId());
        location.setBuilding(locationDto.getBuilding());
        location.setFloor(locationDto.getFloor());
        location.setRoom(locationDto.getRoom());
        return location;
    }

    private LocationDto getLocationDtoInstance(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setLocationId(location.getLocationId());
        locationDto.setBuilding(location.getBuilding());
        locationDto.setFloor(location.getFloor());
        locationDto.setRoom(location.getRoom());
        return locationDto;
    }

}