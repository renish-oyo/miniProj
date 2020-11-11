package com.example.miniproject.mapper;

import com.example.miniproject.models.dto.CompanyDTO;
import com.example.miniproject.models.dto.EmployeeDTO;
import com.example.miniproject.models.dto.UserDTO;
import com.example.miniproject.models.entity.Company;
import com.example.miniproject.models.entity.Employee;
import com.example.miniproject.models.entity.User;
import com.example.miniproject.repository.CompanyRepo;
import com.example.miniproject.repository.EmployeeRepo;
import com.example.miniproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateMapper {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepo employeeRepo;
//    @Autowired
//    private CompanyRepo companyRepo;
//    @Autowired
//    private EmployeeRepo employeeRepo;

    public UserDTO userMap(UserDTO userDTO){
        System.out.println(userDTO);
        Optional<User> user = userRepository.findById(userDTO.getUserId());

        //null fields are replaced with it's original value
        userDTO.setPassword(user.get().getPassword());
        if(userDTO.getFirstName()==null){
            userDTO.setFirstName(user.get().getFirstName());
        }
        if(userDTO.getLastName()==null) {
            userDTO.setLastName(user.get().getLastName());
        }
        if(userDTO.getAadharNumber()==null) {
            userDTO.setAadharNumber(user.get().getAadharNumber());
        }
        if(userDTO.getEmail()==null) {
            userDTO.setEmail(user.get().getEmail());
        }
        if(userDTO.getPanNumber()==null) {
            userDTO.setPanNumber(user.get().getPanNumber());
        }
        if(userDTO.getStreet()==null) {
            userDTO.setStreet(user.get().getStreet());
        }
        if(userDTO.getCity()==null) {
            userDTO.setCity(user.get().getCity());
        }
        if(userDTO.getState()==null) {
            userDTO.setState(user.get().getState());
        }
        if(userDTO.getCountry()==null) {
            userDTO.setCountry(user.get().getCountry());
        }
        if(userDTO.getBankAccountNumber()==null) {
            userDTO.setBankAccountNumber(user.get().getBankAccountNumber());
        }
        if(userDTO.getBankName()==null) {
            userDTO.setBankName(user.get().getBankName());
        }
        if(userDTO.getBanKIfscCode()==null) {
            userDTO.setBanKIfscCode(user.get().getBanKIfscCode());
        }
        if(userDTO.getGender()==null) {
            userDTO.setGender(user.get().getGender());
        }
        if(userDTO.getPhone()==null) {
            userDTO.setPhone(user.get().getPhone());
        }
        if(userDTO.getDesignation()==null){
            userDTO.setDesignation(user.get().getDesignation());
        }
        if(userDTO.getImage()==null){
            userDTO.setImage(user.get().getImage());
        }
        return userDTO;
    }


    public EmployeeDTO employeeMap(EmployeeDTO employeeDTO){
        Optional<Employee> employee = employeeRepo.findById(employeeDTO.getEmployeeId());
        //null fields are replaced with it's original value
        employeeDTO.setPassword(employee.get().getPassword());
        if(employeeDTO.getFirstName()==null){
            employeeDTO.setFirstName(employee.get().getFirstName());
        }
        if(employeeDTO.getLastName()==null) {
            employeeDTO.setLastName(employee.get().getLastName());
        }
        if(employeeDTO.getAadharNumber()==null) {
            employeeDTO.setAadharNumber(employee.get().getAadharNumber());
        }
        if(employeeDTO.getEmail()==null) {
            employeeDTO.setEmail(employee.get().getEmail());
        }
        if(employeeDTO.getPanNumber()==null) {
            employeeDTO.setPanNumber(employee.get().getPanNumber());
        }
        if(employeeDTO.getStreet()==null) {
            employeeDTO.setStreet(employee.get().getStreet());
        }
        if(employeeDTO.getCity()==null) {
            employeeDTO.setCity(employee.get().getCity());
        }
        if(employeeDTO.getState()==null) {
            employeeDTO.setState(employee.get().getState());
        }
        if(employeeDTO.getCountry()==null) {
            employeeDTO.setCountry(employee.get().getCountry());
        }
        if(employeeDTO.getBankAccountNumber()==null) {
            employeeDTO.setBankAccountNumber(employee.get().getBankAccountNumber());
        }
        if(employeeDTO.getBankName()==null) {
            employeeDTO.setBankName(employee.get().getBankName());
        }
        if(employeeDTO.getBanKIfscCode()==null) {
            employeeDTO.setBanKIfscCode(employee.get().getBanKIfscCode());
        }
        if(employeeDTO.getGender()==null) {
            employeeDTO.setGender(employee.get().getGender());
        }
        if(employeeDTO.getPhone()==null) {
            employeeDTO.setPhone(employee.get().getPhone());
        }
        if(employeeDTO.getDesignation()==null){
            employeeDTO.setDesignation(employee.get().getDesignation());
        }
        if(employeeDTO.getImage()==null){
            employeeDTO.setImage(employee.get().getImage());
        }
        if(employeeDTO.getDepartmentId()==0){
            employeeDTO.setDepartmentId(employee.get().getDepartment().getDepartmentId());
        }
        if(employeeDTO.getSalaryId()==0){
            employeeDTO.setSalaryId(employee.get().getSalary().getSalaryId());
        }
        return employeeDTO;
    }
}