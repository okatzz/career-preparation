################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/LenghOfSubstringWithNoRepeatingChar.cpp \
../src/LongestPalindromeSubstring.cpp \
../src/removeSpaceFromString.cpp \
../src/replaceStringPattern.cpp 

OBJS += \
./src/LenghOfSubstringWithNoRepeatingChar.o \
./src/LongestPalindromeSubstring.o \
./src/removeSpaceFromString.o \
./src/replaceStringPattern.o 

CPP_DEPS += \
./src/LenghOfSubstringWithNoRepeatingChar.d \
./src/LongestPalindromeSubstring.d \
./src/removeSpaceFromString.d \
./src/replaceStringPattern.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


