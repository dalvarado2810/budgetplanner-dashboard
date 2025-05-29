package com.daniel.budgetplanner.dashboard.ui.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import com.daniel.base.ui.theme.BackGround
import com.daniel.budgetplanner.dashboard.R
import com.daniel.budgetplanner.dashboard.utils.DROPDOWN_IMAGE
import com.daniel.budgetplanner.dashboard.utils.DashboardTextStyles
import com.daniel.budgetplanner.dashboard.utils.toFormattedName

@Composable
fun HomeTopRow(
    modifier: Modifier = Modifier,
    isMenuShown: Boolean,
    name: String,
    onMenuClick: () -> Unit,
    onMenuDismiss: () -> Unit,
    onPrivacyPolicyClick: () -> Unit,
    onEraseUserClick: () -> Unit,
    onChangeDateClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.dimen_36dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .padding(start = dimensionResource(R.dimen.dimen_24dp)),
            text = name.toFormattedName(),
            color = Color.Black,
            style = DashboardTextStyles.text14spBold
        )

        DropdownMenu(
            modifier = Modifier
                .background(BackGround),
            offset = DpOffset(
                dimensionResource(R.dimen.dimen_248dp),
                dimensionResource(R.dimen.dimen_0dp)
            ),
            expanded = isMenuShown,
            onDismissRequest = {
                onMenuDismiss()
            }
        ) {
            DropdownMenuItem(
                onClick = {
                    onEraseUserClick()
                },
                text = {
                    Text(
                        text = stringResource(id = R.string.erase_user),
                        style = DashboardTextStyles.text12spBlack
                    )
                }
            )

            DropdownMenuItem(
                onClick = {
                    onChangeDateClick()
                },
                text = {
                    Text(
                        text = stringResource(id = R.string.change_date),
                        style = DashboardTextStyles.text12spBlack
                    )
                }
            )

            DropdownMenuItem(
                onClick = {
                    onPrivacyPolicyClick()
                },
                text = {
                    Text(
                        text = stringResource(id = R.string.privacy_policy),
                        style = DashboardTextStyles.text12spBlack
                    )
                }
            )
        }

        IconButton(
            onClick = {
                onMenuClick()
            },
            modifier = Modifier
                .padding(end = dimensionResource(R.dimen.dimen_24dp))
                .sizeIn(dimensionResource(R.dimen.dimen_48dp)),
        ) {
            Image(
                painterResource(id = R.drawable.baseline_menu_24),
                contentDescription = DROPDOWN_IMAGE,
                modifier = Modifier.sizeIn(dimensionResource(R.dimen.dimen_48dp))
            )
        }
    }
}

@Preview(
    name = "HomeTopRow",
    showBackground = true
)
@Composable
fun PreviewHomeTopRow() {
    HomeTopRow(
        isMenuShown = true,
        name = "Daniel Alvarado",
        onMenuClick = {},
        onMenuDismiss = {},
        onEraseUserClick = {},
        onChangeDateClick = {},
        onPrivacyPolicyClick = {}
    )
}
