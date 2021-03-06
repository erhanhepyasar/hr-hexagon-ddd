package com.example.hr.domain;

import com.example.hr.domain.annotation.EntityClass;

import java.util.Objects;

// Entity class -> i) identity, ii) mutable
@EntityClass(identity={"kimlikNo"})
public class Employee {
    private TcKimlikNo kimlikNo;
    private FullName fullname;
    private Money salary;
    private Iban iban;
    private BirthYear birthYear;
    private Department department;
    private JobType jobType;
    private Photo photo;

    public Employee(TcKimlikNo kimlikNo, FullName fullname, Money salary, BirthYear birthYear) {
        this.kimlikNo = kimlikNo;
        this.fullname = fullname;
        this.salary = salary;
        this.birthYear = birthYear;
    }

    public Employee(TcKimlikNo kimlikNo, FullName fullname, Money salary, Iban iban, BirthYear birthYear, Department department, JobType jobType, Photo photo) {
        this.kimlikNo = kimlikNo;
        this.fullname = fullname;
        this.salary = salary;
        this.iban = iban;
        this.birthYear = birthYear;
        this.department = department;
        this.jobType = jobType;
        this.photo = photo;
    }

    public TcKimlikNo getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(TcKimlikNo kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public FullName getFullname() {
        return fullname;
    }

    public void setFullname(FullName fullname) {
        this.fullname = fullname;
    }

    public Money getSalary() {
        return salary;
    }

    public void setSalary(Money salary) {
        this.salary = salary;
    }

    public Iban getIban() {
        return iban;
    }

    public void setIban(Iban iban) {
        this.iban = iban;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(kimlikNo, employee.kimlikNo) &&
                Objects.equals(fullname, employee.fullname) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(iban, employee.iban) &&
                Objects.equals(birthYear, employee.birthYear) &&
                department == employee.department &&
                jobType == employee.jobType &&
                Objects.equals(photo, employee.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kimlikNo, fullname, salary, iban, birthYear, department, jobType, photo);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "kimlikNo=" + kimlikNo +
                ", fullname=" + fullname +
                ", salary=" + salary +
                ", iban=" + iban +
                ", birthYear=" + birthYear +
                ", department=" + department +
                ", jobType=" + jobType +
                ", photo=" + photo +
                '}';
    }


    // Flow API
    /* Example usage:
        new Employee.Builder("135234624564)
                    .fullname("Jack", "Bauer")
                    .salary(10_000, FiatCurrency.TRY)
                    .iban("TR235432345645")
                    .birthYear(1967)
                    .department("SALES")
                    .jobType("FULL_TIME")
                    .build();
     */
    public static class Builder {
        private TcKimlikNo kimlikNo;
        private FullName fullname;
        private Money salary;
        private Iban iban;
        private BirthYear birthYear;
        private Department department;
        private JobType jobType;
        private Photo photo;

        public Builder(TcKimlikNo kimlikNo) {
            this.kimlikNo = kimlikNo;
        }

        public Builder fullname(String first, String last) {
            this.fullname = FullName.of(first, last);
            return this;
        }

        public Builder salary(double value, FiatCurrency currency) {
            this.salary = Money.of(value, currency);
            return this;
        }

        public Builder iban(String value) {
            this.iban = Iban.valueOf(value);
            return this;
        }

        public Builder birthYear(int value) {
            this.birthYear = BirthYear.valueOf(value);
            return this;
        }

        public Builder photo(byte[] data) {
            this.photo = Photo.of(data);
            return this;
        }

        public Builder jobType(String value) {
            this.jobType = JobType.valueOf(value);
            return this;
        }

        public Builder department(String value){
            this.department = Department.valueOf(value);
            return this;
        }

        public Employee build() {
            // validation
            // business rule
            return new Employee(this);
        }
    }

    public Employee(Builder builder) {
        this.kimlikNo = builder.kimlikNo;
        this.fullname = builder.fullname;
        this.salary = builder.salary;
        this.iban = builder.iban;
        this.birthYear = builder.birthYear;
        this.department = builder.department;
        this.jobType = builder.jobType;
        this.photo = builder.photo;
    }
}
