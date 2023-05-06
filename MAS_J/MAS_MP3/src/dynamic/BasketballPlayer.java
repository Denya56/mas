package dynamic;


public class BasketballPlayer {
    private String name;
    private BasketballPlayerType type;
    private Double jumpHeight;
    private Double throwingPower;

    public BasketballPlayer(String name, BasketballPlayerType type, Double jumpHeight, Double throwingPower) {
        setPlayerType(type);
        setName(name);
        if(getPlayerType().equals(BasketballPlayerType.INSIDE)) setJumpHeight(jumpHeight);
        if(getPlayerType().equals(BasketballPlayerType.OUTSIDE)) setThrowingPower(throwingPower);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name must be specified");
        }
        this.name = name;
    }

    public BasketballPlayerType getPlayerType() {
        return type;
    }

    private void setPlayerType(BasketballPlayerType type) {
        if(type == null) {
            throw new IllegalArgumentException("Player type cannot be null");
        }
        this.type = type;
    }

    public Double getThrowingPower() {
        return throwingPower;
    }

    public void setThrowingPower(Double throwingPower) {
        if(throwingPower == null) {
            this.throwingPower = throwingPower;
            return;
        }
        if(throwingPower <= 0) {
            throw new IllegalArgumentException("Throwing power cannot be smaller than 1");
        }
        this.throwingPower = throwingPower;
    }

    public Double getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(Double jumpHeight) {
        if(jumpHeight == null) {
            this.jumpHeight = jumpHeight;
            return;
        }
        if(jumpHeight <= 0) {
            throw new IllegalArgumentException("Jump height cannot be smaller than 1");
        }
        this.jumpHeight = jumpHeight;
    }

    public void changeToInside(Double jumpHeight) {
        stopBeingOutside();
        this.type = BasketballPlayerType.INSIDE;
        setJumpHeight(jumpHeight);
    }

    public void changeToOutside(Double throwingPower) {
        stopBeingInside();
        this.type = BasketballPlayerType.OUTSIDE;
        setThrowingPower(throwingPower);
    }

    private void stopBeingInside() {
        setJumpHeight(null);
    }

    private void stopBeingOutside() {
        setThrowingPower(null);
    }

    @Override
    public String toString() {
        return name + "\nPosition: " + type + "\nJumping height: " + jumpHeight + "\nThrowing power: " + throwingPower;
    }
}
