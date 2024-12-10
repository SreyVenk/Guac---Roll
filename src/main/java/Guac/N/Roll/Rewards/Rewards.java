package Guac.N.Roll.Rewards;

import jakarta.persistence.*;

@Entity
@Table(name = "rewards")
public class Rewards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rewardId;

    @Column(nullable = false)
    private int customerId;

    @Column(nullable = false)
    private int points;

    public Rewards(int rewardId, int customerId, int points) {
        this.rewardId = rewardId;
        this.customerId = customerId;
        this.points = points;
    }

    public Rewards(int customerId, int points) {
        this.customerId = customerId;
        this.points = points;
    }

    public Rewards() {}

    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
