package Guac.N.Roll.Rewards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // Changed to @Controller
@RequestMapping("/rewards")
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    @GetMapping("/all")
    @ResponseBody // Use @ResponseBody for endpoints returning JSON
    public List<Rewards> getAllRewards() {
        return rewardsService.getAllRewards();
    }

    @GetMapping("/{rewardId}")
    @ResponseBody // Use @ResponseBody for endpoints returning JSON
    public Rewards getRewardById(@PathVariable int rewardId) {
        return rewardsService.getRewardById(rewardId);
    }

    @PostMapping("/new")
    @ResponseBody // Use @ResponseBody for endpoints returning JSON
    public List<Rewards> addNewReward(@RequestBody Rewards rewards) {
        rewardsService.addNewReward(rewards);
        return rewardsService.getAllRewards();
    }

    @PutMapping("/update/{rewardId}")
    @ResponseBody // Use @ResponseBody for endpoints returning JSON
    public Rewards updateReward(@PathVariable int rewardId, @RequestBody Rewards rewards) {
        rewardsService.updateReward(rewardId, rewards);
        return rewardsService.getRewardById(rewardId);
    }

    @DeleteMapping("/delete/{rewardId}")
    @ResponseBody // Use @ResponseBody for endpoints returning JSON
    public List<Rewards> deleteReward(@PathVariable int rewardId) {
        rewardsService.deleteReward(rewardId);
        return rewardsService.getAllRewards();
    }

}
