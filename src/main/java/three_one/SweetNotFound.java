package three_one;

//will be used when particular sweet doesn't found in particular place
class SweetNotFound extends RuntimeException {

    SweetNotFound() {
        super("Sweet not found");
    }
}

//will be used when particular sweet is used in bunch and we try to remove it
class UnsupportedDeletionOperation extends RuntimeException {
    UnsupportedDeletionOperation() {
        super("Unsupported operation, impossible to delete sweet which is currently in use");
    }

}

//will be used when some anomaly combination of sweet found in bunch e.g. 50% of bunch is from single type
class WrongSweetBunchCombination extends RuntimeException {
    WrongSweetBunchCombination() {
        super("Wrong sweet bunch combination");
    }
}