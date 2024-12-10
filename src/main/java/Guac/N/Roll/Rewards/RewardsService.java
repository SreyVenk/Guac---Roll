package Guac.N.Roll.Rewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardsService {
    @Autowired
    private RewardsRepository rewardsRepository;

    public List<Rewards> getAllRewards() {
        return rewardsRepository.findAll();
    }

    public Rewards getRewardById(int rewardId) {
        return rewardsRepository.findById(rewardId).orElse(null);
    }

    public void addNewReward(Rewards rewards) {
        rewardsRepository.save(rewards);
    }

    public void updateReward(int rewardId, Rewards rewards) {
        Rewards existing = getRewardById(rewardId);
        if (existing != null) {
            existing.setCustomerId(rewards.getCustomerId());
            existing.setPoints(rewards.getPoints());
            rewardsRepository.save(existing);
        }
    }

    public void deleteReward(int rewardId) {
        rewardsRepository.deleteById(rewardId);
    }
}
