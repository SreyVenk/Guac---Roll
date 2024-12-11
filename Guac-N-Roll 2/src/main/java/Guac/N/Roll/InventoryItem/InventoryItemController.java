package Guac.N.Roll.InventoryItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory_item")
public class InventoryItemController {
    @Autowired
    private InventoryItemService inventoryItemService;

    @PostMapping("/new")
    public List<InventoryItem> addNewInventoryItem(@RequestBody InventoryItem item){
        inventoryItemService.addNewInventoryItem(item);
        return inventoryItemService.getAllInventoryItems();
    }
    @GetMapping("/all")
    public List<InventoryItem> getAllInventoryItems(){
        return inventoryItemService.getAllInventoryItems();
    }
    @GetMapping("/{inventoryItemId}")
    public InventoryItem getOneInventoryItem(@PathVariable int inventoryItemId){
        return inventoryItemService.getInventoryItemById(inventoryItemId);
    }
    @PutMapping("/update/{inventoryItemId}")
    public InventoryItem updateInventoryItem(@PathVariable int inventoryItemId, @RequestBody InventoryItem item){
        inventoryItemService.updateInventoryItem(inventoryItemId, item);
        return inventoryItemService.getInventoryItemById(inventoryItemId);
    }
    @DeleteMapping("/delete/{inventoryItemId}")
    public List<InventoryItem> deleteInventoryItemById(@PathVariable int inventoryItemId) {
        inventoryItemService.deleteInventoryItemById(inventoryItemId);
        return inventoryItemService.getAllInventoryItems();
    }
}