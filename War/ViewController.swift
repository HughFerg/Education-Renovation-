//
//  ViewController.swift
//  War
//
//  Created by Hugh Ferguson on 5/29/17.
//  Copyright © 2017 Hugh Ferguson. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var rightCardView: UIImageView!
    @IBOutlet weak var leftCardView: UIImageView!
    
    @IBOutlet weak var userScore: UILabel!
    @IBOutlet weak var computerScore: UILabel!
    
    var userScoreInt = 0
    var computerScoreint = 0
    
    let cardArray = ["card2","card3","card4","card5","card6","card7","card8","card9","card10","jack","queen","king","ace"]

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func dealButtonTapped(_ sender: Any) {
        
        //Randomizes left card
        let leftNumber = Int(arc4random_uniform(13))
        
        let rightNumber = Int(arc4random_uniform(13))
        
        leftCardView.image = UIImage(named: cardArray[leftNumber])
        
        rightCardView.image = UIImage(named: cardArray[rightNumber])
        //computes score and updates
        
        if rightNumber > leftNumber {
            computerScoreint += 1
            computerScore.text = String(computerScoreint)
        }
        else {
            userScoreInt += 1
            userScore.text = String(userScoreInt)
        }
        
    }

}

