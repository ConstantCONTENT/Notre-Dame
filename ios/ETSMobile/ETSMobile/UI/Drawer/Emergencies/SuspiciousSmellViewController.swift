//
//  SuspiciousSmellViewController.swift
//  ETS-mobile
//
//  Created by Emmanuel on 2018-06-06.
//  Copyright © 2018 applETS. All rights reserved.
//

import UIKit

class SuspiciousSmellViewController: UIViewController {

    @IBOutlet weak var titleLabel: UINavigationItem!
    @IBOutlet weak var instructionsLabel: UITextView!
    @IBOutlet weak var emergencyCallButtonOutlet: UIButton!

    @IBAction func emergencyCallButtonAction(_ sender: Any) {
        UIApplication.shared.open(Environment.current.emergencyNumber())
    }

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.

        instructionsLabel!.attributedText = NSMutableAttributedString(
            string: NSLocalizedString(
                "suspiciousSmellInstructions",
                comment: "Instructions for suspicioulSmell"
            )
        )
        instructionsLabel.font = UIFont(name: instructionsLabel.font!.fontName, size: 16)
        titleLabel.title = NSLocalizedString("suspiciousSmell", comment: "Title for suspiciousSmell")

        emergencyCallButtonOutlet.layer.cornerRadius = 5
        emergencyCallButtonOutlet.setTitle(
            NSLocalizedString(
                "emergencyCall",
                comment: "Emergency call"
            ),
            for: UIControl.State.normal
        )
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    override func viewDidLayoutSubviews() {
        instructionsLabel.setContentOffset(CGPoint.zero, animated: false)
    }

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
